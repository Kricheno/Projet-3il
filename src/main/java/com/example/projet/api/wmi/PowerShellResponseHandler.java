/*
 * Copyright 2015-2018 Javier Garcia Alonso.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.projet.api.wmi;

/**
 * Allows to handle the response using a callback logic. Uses @FunctionalInterface
 * annotation in order to be supported by Java 8+ closures
 *
 * @author Javier Garcia Alonso
 */
@FunctionalInterface
interface PowerShellResponseHandler {
    void handle(PowerShellResponse response);
}
