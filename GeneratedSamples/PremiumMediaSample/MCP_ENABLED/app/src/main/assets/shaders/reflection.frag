#version 300 es
precision mediump float;

in vec2 v_TexCoord;

out vec4 o_FragColor;

uniform sampler2D u_SceneTexture;

void main()
{
    vec4 color = texture(u_SceneTexture, v_TexCoord);
    o_FragColor = vec4(color.rgb * 0.8, 1.0); // Simple reflection effect
}
