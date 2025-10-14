#version 300 es
precision mediump float;

in vec2 v_TexCoord;
out vec4 outColor;

uniform sampler2D u_SceneTexture;
uniform vec4 u_Color;

void main() {
    vec2 flippedTexCoord = vec2(v_TexCoord.x, 1.0 - v_TexCoord.y);
    vec4 sceneColor = texture(u_SceneTexture, flippedTexCoord);
    outColor = u_Color * sceneColor;
}
