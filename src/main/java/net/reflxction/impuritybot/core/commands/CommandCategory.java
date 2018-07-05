package net.reflxction.impuritybot.core.commands;

/*
 * * Copyright 2017-2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public enum CommandCategory {

    ADMIN("Admin"),

    MINECRAFT("Minecraft"),

    LEVEL("Level"),

    FUN("Fun"),

    USER("User"),

    HELP("Help"),

    CREDITS("Credits"),

    CALENDAR("Calendar"),

    POINTS("Points"),

    MUSIC("Music"),

    OTHERS("Others");

    private String name;

    CommandCategory(String enumName) {
        this.name = enumName;
    }

    @Override
    public String toString() {
        return name;
    }

}
