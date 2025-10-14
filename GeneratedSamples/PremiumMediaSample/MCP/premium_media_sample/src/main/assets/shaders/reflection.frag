#version 310 es
precision mediump float;

uniform sampler2D u_SceneTexture;
in vec2 v_TexCoord;
out vec4 o_FragColor;

void main() {
    // Simple reflection effect: just sample the texture and add some tint
    vec4 color = texture(u_SceneTexture, v_TexCoord);
    o_FragColor = color * vec4(0.8, 0.8, 1.0, 1.0);
}
