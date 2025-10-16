
#version 300 es
precision mediump float;

in vec2 v_TexCoord;
out vec4 o_Color;

uniform sampler2D u_SceneTexture;

void main() {
    vec4 sceneColor = texture(u_SceneTexture, v_TexCoord);
    o_Color = vec4(sceneColor.rgb * 0.8, 1.0); // Simple reflection effect
}
