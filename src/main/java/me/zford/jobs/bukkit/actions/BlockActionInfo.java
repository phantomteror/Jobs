/**
 * Jobs Plugin for Bukkit
 * Copyright (C) 2011 Zak Ford <zak.j.ford@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zford.jobs.bukkit.actions;

import me.zford.jobs.container.ActionInfo;
import me.zford.jobs.container.ActionType;
import me.zford.jobs.container.BaseActionInfo;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockActionInfo extends BaseActionInfo implements ActionInfo {
    private Block block;
    public BlockActionInfo(Block block, ActionType type) {
        super(type);
        this.block = block;
    }
    
    @Override
    public String getName() {
        // Normalize GLOWING_REDSTONE_ORE to REDSTONE_ORE
        if (block.getType().equals(Material.GLOWING_REDSTONE_ORE))
            return Material.REDSTONE_ORE.toString();
        
        return block.getType().toString();
    }

    @Override
    public String getNameWithSub() {
        return getName()+":"+block.getData();
    }
}
