/*
 * Copyright (c) Meta Platforms, Inc. and affiliates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#version 300 es
in vec3 a_position;
in vec2 a_texCoord;
out vec2 v_texCoord;
uniform mat4 u_MVP;
void main() {
  gl_Position = u_MVP * vec4(a_position, 1.0);
  v_texCoord = a_texCoord;
}
