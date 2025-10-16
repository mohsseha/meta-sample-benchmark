#!/usr/bin/env python3
"""
Apple-inspired visualization script for judgement data.
Minimalist, story-driven approach focusing on key insights.
"""

import json
import os
from pathlib import Path
from typing import Dict, List, Any
import plotly.graph_objects as go
import pandas as pd


def load_judgements(judgements_dir: str = "judgements") -> Dict[str, Any]:
    """Load all JSON files from the judgements directory."""
    judgements = {}
    judgements_path = Path(judgements_dir)

    for json_file in sorted(judgements_path.glob("*.json")):
        sample_name = json_file.stem
        try:
            with open(json_file, 'r') as f:
                judgements[sample_name] = json.load(f)
            print(f"  ✓ Loaded {sample_name}")
        except json.JSONDecodeError as e:
            print(f"  ✗ Error loading {sample_name}: {e}")
            print(f"    Skipping {json_file}")
            continue

    return judgements


def extract_scores(judgements: Dict[str, Any]) -> pd.DataFrame:
    """Extract all scores into a structured DataFrame."""
    rows = []

    for sample_name, data in judgements.items():
        for sub_req in data.get("SubRequirements", []):
            requirement = sub_req["requirement"]

            # MCP scores
            mcp_impl = sub_req["MCP"]["implementation"]["score"]
            mcp_corr = sub_req["MCP"]["correctness"]["score"]
            mcp_impl_just = sub_req["MCP"]["implementation"].get("justification", "")
            mcp_corr_just = sub_req["MCP"]["correctness"].get("justification", "")

            # NO_MCP scores
            no_mcp_impl = sub_req["NO_MCP"]["implementation"]["score"]
            no_mcp_corr = sub_req["NO_MCP"]["correctness"]["score"]
            no_mcp_impl_just = sub_req["NO_MCP"]["implementation"].get("justification", "")
            no_mcp_corr_just = sub_req["NO_MCP"]["correctness"].get("justification", "")

            rows.append({
                "Sample": sample_name,
                "Requirement": requirement,
                "MCP_Implementation": mcp_impl,
                "MCP_Correctness": mcp_corr,
                "MCP_Total": mcp_impl + mcp_corr,
                "MCP_Impl_Just": mcp_impl_just,
                "MCP_Corr_Just": mcp_corr_just,
                "NO_MCP_Implementation": no_mcp_impl,
                "NO_MCP_Correctness": no_mcp_corr,
                "NO_MCP_Total": no_mcp_impl + no_mcp_corr,
                "NO_MCP_Impl_Just": no_mcp_impl_just,
                "NO_MCP_Corr_Just": no_mcp_corr_just,
                "RefEvidence": sub_req.get("refEvidence", "")
            })

    return pd.DataFrame(rows)


def create_hero_gauge(avg_win_prob: float) -> str:
    """Create a large circular gauge for the hero section."""
    fig = go.Figure(go.Indicator(
        mode="gauge+number",
        value=avg_win_prob * 100,
        domain={'x': [0, 1], 'y': [0, 1]},
        number={'suffix': "%", 'font': {'size': 72, 'family': 'SF Pro Display, -apple-system, sans-serif'}},
        gauge={
            'axis': {'range': [None, 100], 'tickwidth': 1, 'tickcolor': "#E5E5E5"},
            'bar': {'color': "#34C759", 'thickness': 0.8},
            'bgcolor': "white",
            'borderwidth': 0,
            'bordercolor': "white",
            'steps': [
                {'range': [0, 40], 'color': '#FFE5E5'},
                {'range': [40, 60], 'color': '#F5F5F5'},
                {'range': [60, 100], 'color': '#E8F5E9'}
            ],
            'threshold': {
                'line': {'color': "black", 'width': 2},
                'thickness': 0.75,
                'value': avg_win_prob * 100
            }
        }
    ))

    fig.update_layout(
        paper_bgcolor="white",
        font={'family': 'SF Pro Display, -apple-system, sans-serif', 'color': "#1D1D1F"},
        height=400,
        margin=dict(l=40, r=40, t=20, b=20)
    )

    return fig.to_json()


def create_sample_gauges(judgements: Dict[str, Any]) -> str:
    """Create circular progress indicators for each sample."""
    samples = list(judgements.keys())
    win_probs = [judgements[s]["MCPWinProbability"] for s in samples]

    # Determine colors based on win probability
    colors = []
    for prob in win_probs:
        if prob >= 0.6:
            colors.append('#34C759')  # Green
        elif prob <= 0.4:
            colors.append('#FF3B30')  # Red
        else:
            colors.append('#8E8E93')  # Gray

    fig = go.Figure()

    # Create individual gauge-like indicators using pie charts for circular effect
    for i, (sample, prob, color) in enumerate(zip(samples, win_probs, colors)):
        fig.add_trace(go.Indicator(
            mode="gauge+number+delta",
            value=prob * 100,
            domain={'row': i // 4, 'column': i % 4},
            title={'text': sample, 'font': {'size': 14, 'family': 'SF Pro Display, -apple-system, sans-serif'}},
            number={'suffix': "%", 'font': {'size': 28}},
            gauge={
                'axis': {'range': [None, 100], 'visible': False},
                'bar': {'color': color, 'thickness': 1},
                'bgcolor': "white",
                'borderwidth': 0,
                'steps': [
                    {'range': [0, 100], 'color': '#F5F5F5'}
                ],
            }
        ))

    rows = (len(samples) + 3) // 4
    fig.update_layout(
        grid={'rows': rows, 'columns': 4, 'pattern': "independent"},
        paper_bgcolor="white",
        font={'family': 'SF Pro Display, -apple-system, sans-serif', 'color': "#1D1D1F"},
        height=300 * rows,
        margin=dict(l=20, r=20, t=40, b=20)
    )

    return fig.to_json()


def create_score_comparison(df: pd.DataFrame) -> str:
    """Create grouped bars for side-by-side comparison of Implementation vs Correctness."""
    avg_mcp_impl = df["MCP_Implementation"].mean()
    avg_mcp_corr = df["MCP_Correctness"].mean()
    avg_no_mcp_impl = df["NO_MCP_Implementation"].mean()
    avg_no_mcp_corr = df["NO_MCP_Correctness"].mean()

    fig = go.Figure()

    # MCP bars
    fig.add_trace(go.Bar(
        name='MCP',
        x=['Implementation', 'Correctness'],
        y=[avg_mcp_impl, avg_mcp_corr],
        marker=dict(color='#34C759'),
        text=[f'{avg_mcp_impl:.2f}', f'{avg_mcp_corr:.2f}'],
        textposition='outside',
        textfont=dict(size=18, family='SF Pro Display, -apple-system, sans-serif', color='#34C759'),
        hovertemplate='<b>MCP %{x}</b><br>Score: %{y:.2f} / 2.0<extra></extra>'
    ))

    # NO_MCP bars
    fig.add_trace(go.Bar(
        name='NO_MCP',
        x=['Implementation', 'Correctness'],
        y=[avg_no_mcp_impl, avg_no_mcp_corr],
        marker=dict(color='#FF3B30'),
        text=[f'{avg_no_mcp_impl:.2f}', f'{avg_no_mcp_corr:.2f}'],
        textposition='outside',
        textfont=dict(size=18, family='SF Pro Display, -apple-system, sans-serif', color='#FF3B30'),
        hovertemplate='<b>NO_MCP %{x}</b><br>Score: %{y:.2f} / 2.0<extra></extra>'
    ))

    fig.update_layout(
        barmode='group',
        paper_bgcolor='white',
        plot_bgcolor='white',
        font={'family': 'SF Pro Display, -apple-system, sans-serif', 'color': '#1D1D1F'},
        xaxis=dict(
            title='',
            showgrid=False
        ),
        yaxis=dict(
            title='Average Score (0-2 scale)',
            range=[0, 2.2],
            showgrid=True,
            gridcolor='#F5F5F5',
            tick0=0,
            dtick=0.5
        ),
        height=400,
        margin=dict(l=80, r=40, t=40, b=80),
        legend=dict(
            orientation="h",
            yanchor="bottom",
            y=-0.2,
            xanchor="center",
            x=0.5
        ),
        bargap=0.3,
        bargroupgap=0.1
    )

    # Add reference line at 1.0 (midpoint)
    fig.add_hline(y=1.0, line_dash="dash", line_color="#8E8E93", opacity=0.5,
                  annotation_text="Midpoint (1.0)", annotation_position="right")

    return fig.to_json()


def generate_sample_cards_html(judgements: Dict[str, Any], df: pd.DataFrame) -> str:
    """Generate HTML for expandable sample cards."""
    cards_html = ""

    for sample_name, data in sorted(judgements.items()):
        win_prob = data["MCPWinProbability"]
        reasoning = data["MCPWinReasoning"]

        # Determine color
        if win_prob >= 0.6:
            color = '#34C759'
            verdict = 'MCP Advantage'
        elif win_prob <= 0.4:
            color = '#FF3B30'
            verdict = 'NO_MCP Advantage'
        else:
            color = '#8E8E93'
            verdict = 'Close Call'

        # Get sub-requirements for this sample
        sample_reqs = df[df['Sample'] == sample_name]

        # Calculate MCP and NO_MCP averages for this sample (for collapsed view gauges)
        mcp_impl_avg = sample_reqs['MCP_Implementation'].mean()
        mcp_corr_avg = sample_reqs['MCP_Correctness'].mean()
        no_mcp_impl_avg = sample_reqs['NO_MCP_Implementation'].mean()
        no_mcp_corr_avg = sample_reqs['NO_MCP_Correctness'].mean()

        # Calculate positions for dots on 0-2 scale (as percentage)
        mcp_impl_pos = (mcp_impl_avg / 2.0) * 100
        mcp_corr_pos = (mcp_corr_avg / 2.0) * 100
        no_mcp_impl_pos = (no_mcp_impl_avg / 2.0) * 100
        no_mcp_corr_pos = (no_mcp_corr_avg / 2.0) * 100

        reqs_html = ""
        for _, req in sample_reqs.iterrows():
            winner = "MCP" if req['MCP_Total'] > req['NO_MCP_Total'] else ("NO_MCP" if req['NO_MCP_Total'] > req['MCP_Total'] else "Tie")
            winner_color = '#34C759' if winner == 'MCP' else ('#FF3B30' if winner == 'NO_MCP' else '#8E8E93')

            # Create dot visualization for scores
            mcp_impl_dots = '●' * int(req['MCP_Implementation']) + '○' * (2 - int(req['MCP_Implementation']))
            mcp_corr_dots = '●' * int(req['MCP_Correctness']) + '○' * (2 - int(req['MCP_Correctness']))
            no_mcp_impl_dots = '●' * int(req['NO_MCP_Implementation']) + '○' * (2 - int(req['NO_MCP_Implementation']))
            no_mcp_corr_dots = '●' * int(req['NO_MCP_Correctness']) + '○' * (2 - int(req['NO_MCP_Correctness']))

            reqs_html += f"""
            <div class="requirement-card">
                <div class="requirement-header">
                    <h4>{req['Requirement']}</h4>
                    <span class="winner-badge" style="background-color: {winner_color};">{winner}</span>
                </div>

                <div class="ref-evidence">
                    <strong>Reference:</strong> <code>{req['RefEvidence']}</code>
                </div>

                <div class="score-comparison">
                    <div class="score-column">
                        <h5>MCP</h5>
                        <div class="score-row">
                            <span class="score-label">Implementation:</span>
                            <span class="score-dots" style="color: #34C759;">{mcp_impl_dots}</span>
                            <span class="score-number">{int(req['MCP_Implementation'])}</span>
                        </div>
                        <p class="justification">{req['MCP_Impl_Just']}</p>

                        <div class="score-row">
                            <span class="score-label">Correctness:</span>
                            <span class="score-dots" style="color: #007AFF;">{mcp_corr_dots}</span>
                            <span class="score-number">{int(req['MCP_Correctness'])}</span>
                        </div>
                        <p class="justification">{req['MCP_Corr_Just']}</p>
                    </div>

                    <div class="score-column">
                        <h5>NO_MCP</h5>
                        <div class="score-row">
                            <span class="score-label">Implementation:</span>
                            <span class="score-dots" style="color: #34C759;">{no_mcp_impl_dots}</span>
                            <span class="score-number">{int(req['NO_MCP_Implementation'])}</span>
                        </div>
                        <p class="justification">{req['NO_MCP_Impl_Just']}</p>

                        <div class="score-row">
                            <span class="score-label">Correctness:</span>
                            <span class="score-dots" style="color: #007AFF;">{no_mcp_corr_dots}</span>
                            <span class="score-number">{int(req['NO_MCP_Correctness'])}</span>
                        </div>
                        <p class="justification">{req['NO_MCP_Corr_Just']}</p>
                    </div>
                </div>
            </div>
            """

        cards_html += f"""
        <div class="sample-card">
            <div class="sample-card-header" onclick="toggleCard('{sample_name}')">
                <div class="sample-title">
                    <h3>{sample_name}</h3>
                    <span class="verdict-badge" style="background-color: {color};">{verdict}</span>
                </div>
                <div class="sample-win-prob">
                    <div class="win-prob-number" style="color: {color};">{win_prob:.1%}</div>
                    <div class="win-prob-label">Win Probability</div>
                </div>
                <div class="sample-avg-bars">
                    <div class="avg-gauge-row">
                        <span class="avg-gauge-label">🔨 Implementation</span>
                        <div class="gauge-track">
                            <span class="gauge-tick" style="left: 0%">0</span>
                            <span class="gauge-tick" style="left: 50%">1</span>
                            <span class="gauge-tick" style="left: 100%">2</span>
                            <div class="gauge-indicator mcp-indicator" style="left: {mcp_impl_pos}%" title="MCP: {mcp_impl_avg:.2f}">
                                <span class="indicator-value">{mcp_impl_avg:.2f}</span>
                            </div>
                            <div class="gauge-indicator no-mcp-indicator" style="left: {no_mcp_impl_pos}%" title="NO_MCP: {no_mcp_impl_avg:.2f}">
                                <span class="indicator-value">{no_mcp_impl_avg:.2f}</span>
                            </div>
                        </div>
                    </div>
                    <div class="avg-gauge-row">
                        <span class="avg-gauge-label">🎯 Correctness</span>
                        <div class="gauge-track">
                            <span class="gauge-tick" style="left: 0%">0</span>
                            <span class="gauge-tick" style="left: 50%">1</span>
                            <span class="gauge-tick" style="left: 100%">2</span>
                            <div class="gauge-indicator mcp-indicator" style="left: {mcp_corr_pos}%" title="MCP: {mcp_corr_avg:.2f}">
                                <span class="indicator-value">{mcp_corr_avg:.2f}</span>
                            </div>
                            <div class="gauge-indicator no-mcp-indicator" style="left: {no_mcp_corr_pos}%" title="NO_MCP: {no_mcp_corr_avg:.2f}">
                                <span class="indicator-value">{no_mcp_corr_avg:.2f}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <span class="expand-icon" id="icon-{sample_name}">▼</span>
            </div>

            <div class="sample-card-content" id="content-{sample_name}">
                <div class="reasoning-section">
                    <h4>Analysis</h4>
                    <p>{reasoning}</p>
                </div>

                <div class="requirements-section">
                    <h4>Sub-Requirements Breakdown</h4>
                    {reqs_html}
                </div>
            </div>
        </div>
        """

    return cards_html


def create_full_html(judgements: Dict[str, Any]) -> str:
    """Create the complete Apple-styled HTML dashboard."""
    df = extract_scores(judgements)

    # Calculate summary stats
    total_requirements = len(df)
    mcp_wins = len(df[df["MCP_Total"] > df["NO_MCP_Total"]])
    no_mcp_wins = len(df[df["NO_MCP_Total"] > df["MCP_Total"]])
    ties = len(df[df["MCP_Total"] == df["NO_MCP_Total"]])
    avg_win_prob = sum(j["MCPWinProbability"] for j in judgements.values()) / len(judgements)

    # Generate visualizations
    hero_gauge_json = create_hero_gauge(avg_win_prob)
    sample_gauges_json = create_sample_gauges(judgements)
    score_comparison_json = create_score_comparison(df)

    # Generate sample cards
    sample_cards_html = generate_sample_cards_html(judgements, df)

    html_content = f"""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MCP vs NO_MCP Analysis - Apple Design</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <style>
        * {{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }}

        body {{
            font-family: 'SF Pro Display', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            background: linear-gradient(to bottom, #F5F5F7 0%, #FFFFFF 100%);
            color: #1D1D1F;
            line-height: 1.6;
            -webkit-font-smoothing: antialiased;
        }}

        .container {{
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
        }}

        /* Hero Section */
        .hero-section {{
            text-align: center;
            padding: 80px 20px;
            background: white;
            border-radius: 24px;
            box-shadow: 0 4px 24px rgba(0, 0, 0, 0.06);
            margin-bottom: 60px;
        }}

        .hero-title {{
            font-size: 56px;
            font-weight: 700;
            letter-spacing: -0.5px;
            margin-bottom: 16px;
            background: linear-gradient(90deg, #34C759, #007AFF);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }}

        .hero-subtitle {{
            font-size: 24px;
            font-weight: 400;
            color: #6E6E73;
            margin-bottom: 60px;
        }}

        /* Stats Grid */
        .stats-grid {{
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin: 40px 0 60px 0;
        }}

        .stat-box {{
            background: white;
            padding: 32px;
            border-radius: 16px;
            text-align: center;
            box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }}

        .stat-box:hover {{
            transform: translateY(-4px);
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
        }}

        .stat-number {{
            font-size: 48px;
            font-weight: 700;
            margin-bottom: 8px;
        }}

        .stat-number.green {{ color: #34C759; }}
        .stat-number.red {{ color: #FF3B30; }}
        .stat-number.gray {{ color: #8E8E93; }}
        .stat-number.blue {{ color: #007AFF; }}

        .stat-label {{
            font-size: 16px;
            color: #6E6E73;
            font-weight: 500;
        }}

        /* Section Headers */
        .section {{
            margin: 80px 0;
        }}

        .section-header {{
            text-align: center;
            margin-bottom: 60px;
        }}

        .section-title {{
            font-size: 40px;
            font-weight: 700;
            margin-bottom: 12px;
        }}

        .section-description {{
            font-size: 18px;
            color: #6E6E73;
            max-width: 600px;
            margin: 0 auto;
        }}

        /* Score Legend */
        .score-legend-container {{
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 40px;
            max-width: 1000px;
            margin: 0 auto;
        }}

        .score-legend-card {{
            background: white;
            border-radius: 20px;
            padding: 40px;
            box-shadow: 0 4px 24px rgba(0, 0, 0, 0.06);
            text-align: center;
        }}

        .score-legend-icon {{
            font-size: 64px;
            margin-bottom: 20px;
        }}

        .score-legend-card h3 {{
            font-size: 28px;
            font-weight: 700;
            margin-bottom: 8px;
        }}

        .score-legend-subtitle {{
            font-size: 16px;
            color: #6E6E73;
            margin-bottom: 32px;
        }}

        .score-tier {{
            display: flex;
            align-items: center;
            gap: 16px;
            padding: 16px;
            margin-bottom: 12px;
            background: #F5F5F7;
            border-radius: 12px;
            text-align: left;
        }}

        .score-badge {{
            width: 44px;
            height: 44px;
            border-radius: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            font-weight: 700;
            color: white;
            flex-shrink: 0;
        }}

        .score-badge.green {{
            background: #34C759;
        }}

        .score-badge.yellow {{
            background: #FF9500;
        }}

        .score-badge.red {{
            background: #FF3B30;
        }}

        .score-desc {{
            font-size: 15px;
            color: #1D1D1F;
            line-height: 1.5;
        }}

        /* Visualization Containers */
        .viz-container {{
            background: white;
            border-radius: 24px;
            padding: 40px;
            box-shadow: 0 4px 24px rgba(0, 0, 0, 0.06);
            margin-bottom: 40px;
        }}

        /* Sample Cards */
        .sample-card {{
            background: white;
            border-radius: 16px;
            margin-bottom: 20px;
            box-shadow: 0 2px 12px rgba(0, 0, 0, 0.04);
            overflow: hidden;
            transition: box-shadow 0.3s ease;
        }}

        .sample-card:hover {{
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
        }}

        .sample-card-header {{
            padding: 24px 32px;
            cursor: pointer;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: linear-gradient(to right, #FAFAFA 0%, #FFFFFF 100%);
            border-bottom: 1px solid #F5F5F5;
        }}

        .sample-title {{
            display: flex;
            align-items: center;
            gap: 16px;
            flex: 1;
        }}

        .sample-title h3 {{
            font-size: 24px;
            font-weight: 600;
        }}

        .verdict-badge {{
            padding: 6px 16px;
            border-radius: 20px;
            color: white;
            font-size: 14px;
            font-weight: 600;
        }}

        .sample-win-prob {{
            text-align: right;
            margin-right: 24px;
        }}

        .win-prob-number {{
            font-size: 32px;
            font-weight: 700;
        }}

        .win-prob-label {{
            font-size: 12px;
            color: #6E6E73;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }}

        /* MCP vs NO_MCP Gauge Bars in Collapsed View */
        .sample-avg-bars {{
            display: flex;
            flex-direction: column;
            gap: 12px;
            margin-right: 24px;
            min-width: 320px;
        }}

        .avg-gauge-row {{
            display: flex;
            flex-direction: column;
            gap: 4px;
        }}

        .avg-gauge-label {{
            font-size: 12px;
            font-weight: 600;
            color: #6E6E73;
        }}

        .gauge-track {{
            position: relative;
            height: 30px;
            background: #F5F5F7;
            border-radius: 6px;
            width: 100%;
        }}

        .gauge-tick {{
            position: absolute;
            top: 50%;
            transform: translate(-50%, -50%);
            font-size: 10px;
            color: #8E8E93;
            font-weight: 500;
            pointer-events: none;
        }}

        .gauge-indicator {{
            position: absolute;
            top: 50%;
            transform: translate(-50%, -50%);
            width: 12px;
            height: 12px;
            border-radius: 50%;
            border: 2px solid white;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
            cursor: pointer;
        }}

        .gauge-indicator:hover {{
            transform: translate(-50%, -50%) scale(1.3);
            box-shadow: 0 3px 12px rgba(0, 0, 0, 0.3);
        }}

        .mcp-indicator {{
            background: #34C759;
            z-index: 2;
        }}

        .no-mcp-indicator {{
            background: #FF3B30;
            z-index: 1;
        }}

        .indicator-value {{
            position: absolute;
            top: -22px;
            left: 50%;
            transform: translateX(-50%);
            font-size: 10px;
            font-weight: 600;
            white-space: nowrap;
            background: rgba(255, 255, 255, 0.95);
            padding: 2px 6px;
            border-radius: 4px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
            opacity: 0;
            pointer-events: none;
            transition: opacity 0.2s ease;
        }}

        .gauge-indicator:hover .indicator-value {{
            opacity: 1;
        }}

        .expand-icon {{
            font-size: 20px;
            color: #6E6E73;
            transition: transform 0.3s ease;
        }}

        .expand-icon.expanded {{
            transform: rotate(180deg);
        }}

        .sample-card-content {{
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.5s ease;
        }}

        .sample-card-content.expanded {{
            max-height: 10000px;
        }}

        .reasoning-section {{
            padding: 32px;
            background: #FAFAFA;
            border-bottom: 1px solid #F5F5F5;
        }}

        .reasoning-section h4 {{
            font-size: 18px;
            font-weight: 600;
            margin-bottom: 12px;
            color: #1D1D1F;
        }}

        .reasoning-section p {{
            font-size: 16px;
            color: #3A3A3C;
            line-height: 1.8;
        }}

        .requirements-section {{
            padding: 32px;
        }}

        .requirements-section h4 {{
            font-size: 20px;
            font-weight: 600;
            margin-bottom: 24px;
        }}

        .requirement-card {{
            background: #FAFAFA;
            border-radius: 12px;
            padding: 24px;
            margin-bottom: 20px;
        }}

        .requirement-header {{
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 16px;
        }}

        .requirement-header h4 {{
            font-size: 18px;
            font-weight: 600;
            flex: 1;
        }}

        .winner-badge {{
            padding: 4px 12px;
            border-radius: 12px;
            color: white;
            font-size: 12px;
            font-weight: 600;
        }}

        .ref-evidence {{
            background: white;
            padding: 16px;
            border-radius: 8px;
            margin-bottom: 20px;
            font-size: 14px;
        }}

        .ref-evidence code {{
            background: #F5F5F5;
            padding: 2px 6px;
            border-radius: 4px;
            font-family: 'SF Mono', Monaco, monospace;
            font-size: 13px;
        }}

        .score-comparison {{
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 24px;
        }}

        .score-column {{
            background: white;
            padding: 20px;
            border-radius: 8px;
        }}

        .score-column h5 {{
            font-size: 16px;
            font-weight: 600;
            margin-bottom: 16px;
            color: #1D1D1F;
        }}

        .score-row {{
            display: flex;
            align-items: center;
            gap: 8px;
            margin-bottom: 8px;
        }}

        .score-label {{
            font-size: 14px;
            font-weight: 500;
            color: #6E6E73;
            min-width: 120px;
        }}

        .score-dots {{
            font-size: 18px;
            letter-spacing: 2px;
        }}

        .score-number {{
            font-size: 16px;
            font-weight: 600;
            color: #1D1D1F;
        }}

        .justification {{
            font-size: 14px;
            color: #3A3A3C;
            line-height: 1.6;
            margin: 8px 0 16px 0;
            padding-left: 12px;
            border-left: 3px solid #F5F5F5;
        }}

        /* Footer */
        .footer {{
            text-align: center;
            padding: 60px 20px;
            color: #6E6E73;
            font-size: 14px;
        }}
    </style>
</head>
<body>
    <div class="container">
        <!-- Hero Section -->
        <div class="hero-section">
            <h1 class="hero-title">MCP Performance Analysis</h1>
            <p class="hero-subtitle">Comparing AI-generated implementations with and without specialized documentation tools</p>

            <div id="hero-gauge"></div>

            <div class="stats-grid">
                <div class="stat-box">
                    <div class="stat-number blue">{len(judgements)}</div>
                    <div class="stat-label">Samples Analyzed</div>
                </div>
                <div class="stat-box">
                    <div class="stat-number green">{mcp_wins}</div>
                    <div class="stat-label">MCP Wins</div>
                </div>
                <div class="stat-box">
                    <div class="stat-number red">{no_mcp_wins}</div>
                    <div class="stat-label">NO_MCP Wins</div>
                </div>
                <div class="stat-box">
                    <div class="stat-number gray">{ties}</div>
                    <div class="stat-label">Tied Requirements</div>
                </div>
            </div>
        </div>

        <!-- Panel 1: The Verdict -->
        <div class="section">
            <div class="section-header">
                <h2 class="section-title">The Verdict</h2>
                <p class="section-description">Win probability for each sample, showing which approach produced better results</p>
            </div>

            <div class="viz-container">
                <div id="sample-gauges"></div>
            </div>
        </div>

        <!-- Score Legend Section -->
        <div class="section">
            <div class="section-header">
                <h2 class="section-title">Understanding the Scores</h2>
                <p class="section-description">Each requirement is evaluated on two dimensions, scored 0-2</p>
            </div>

            <div class="score-legend-container">
                <div class="score-legend-card">
                    <div class="score-legend-icon">🔨</div>
                    <h3>Implementation</h3>
                    <p class="score-legend-subtitle">How complete is the attempt?</p>
                    <div class="score-tier">
                        <span class="score-badge red">0</span>
                        <span class="score-desc">Not attempted or no evidence</span>
                    </div>
                    <div class="score-tier">
                        <span class="score-badge yellow">1</span>
                        <span class="score-desc">Partial structure, but incomplete</span>
                    </div>
                    <div class="score-tier">
                        <span class="score-badge green">2</span>
                        <span class="score-desc">Fully implemented and complete</span>
                    </div>
                </div>

                <div class="score-legend-card">
                    <div class="score-legend-icon">🎯</div>
                    <h3>Correctness</h3>
                    <p class="score-legend-subtitle">Are the APIs real or invented?</p>
                    <div class="score-tier">
                        <span class="score-badge red">0</span>
                        <span class="score-desc">Hallucinated APIs, fictional classes</span>
                    </div>
                    <div class="score-tier">
                        <span class="score-badge yellow">1</span>
                        <span class="score-desc">Mix of correct and incorrect APIs</span>
                    </div>
                    <div class="score-tier">
                        <span class="score-badge green">2</span>
                        <span class="score-desc">Correct API usage, matches reference</span>
                    </div>
                </div>
            </div>
        </div>

        <!-- Panel 2: Performance Comparison -->
        <div class="section">
            <div class="section-header">
                <h2 class="section-title">Performance Comparison</h2>
                <p class="section-description">Average scores across all {total_requirements} requirements (higher is better)</p>
            </div>

            <div class="viz-container">
                <div id="score-comparison"></div>
            </div>
        </div>

        <!-- Panel 3: The Details -->
        <div class="section">
            <div class="section-header">
                <h2 class="section-title">The Details</h2>
                <p class="section-description">Deep dive into each sample with full analysis and sub-requirement breakdowns</p>
            </div>

            {sample_cards_html}
        </div>

        <div class="footer">
            <p>Generated with Apple-inspired design principles • {len(judgements)} samples • {total_requirements} requirements evaluated</p>
        </div>
    </div>

    <script>
        // Load visualizations
        var heroGaugeData = {hero_gauge_json};
        Plotly.newPlot('hero-gauge', heroGaugeData.data, heroGaugeData.layout, {{displayModeBar: false}});

        var sampleGaugesData = {sample_gauges_json};
        Plotly.newPlot('sample-gauges', sampleGaugesData.data, sampleGaugesData.layout, {{displayModeBar: false}});

        var scoreComparisonData = {score_comparison_json};
        Plotly.newPlot('score-comparison', scoreComparisonData.data, scoreComparisonData.layout, {{displayModeBar: false}});

        // Card expansion functionality
        function toggleCard(sampleName) {{
            const content = document.getElementById('content-' + sampleName);
            const icon = document.getElementById('icon-' + sampleName);

            if (content.classList.contains('expanded')) {{
                content.classList.remove('expanded');
                icon.classList.remove('expanded');
            }} else {{
                content.classList.add('expanded');
                icon.classList.add('expanded');
            }}
        }}

        // Smooth scroll animation on load
        window.addEventListener('load', function() {{
            document.querySelectorAll('.stat-box').forEach((box, index) => {{
                setTimeout(() => {{
                    box.style.opacity = '0';
                    box.style.transform = 'translateY(20px)';
                    setTimeout(() => {{
                        box.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
                        box.style.opacity = '1';
                        box.style.transform = 'translateY(0)';
                    }}, 50);
                }}, index * 100);
            }});
        }});
    </script>
</body>
</html>
"""

    return html_content


def main():
    """Main function to generate the Apple-styled dashboard."""
    script_dir = Path(__file__).parent
    judgements_dir = script_dir / "judgements"

    print("Loading judgement data...")
    print(f"Scanning: {judgements_dir}")
    judgements = load_judgements(str(judgements_dir))

    if not judgements:
        print("ERROR: No valid judgement files found!")
        return

    print(f"\nSuccessfully loaded {len(judgements)} samples")

    print("\nGenerating Apple-styled dashboard...")
    html_content = create_full_html(judgements)

    output_file = judgements_dir / "judgements_dashboard_apple.html"
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(html_content)

    print(f"\n✓ Apple-styled dashboard generated: {output_file}")
    print(f"  Open this file in a web browser to view the minimalist, story-driven dashboard")


if __name__ == "__main__":
    main()
