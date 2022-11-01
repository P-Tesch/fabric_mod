package com.tesch.typemoon;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tesch.typemoon.items.ItemRegister;

public class TypeMoonMod implements ModInitializer {

	public static final String MOD_ID = "typemoon";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ItemRegister.registerItems();

		LOGGER.info("Type Moon mod initialized");
	}
}
