# Reach Mod

A Minecraft Fabric mod that allows you to adjust your player reach distance from 1 to 10 blocks with an easy-to-use UI.

## Features

- **Adjustable Reach Distance**: Modify your reach distance from 1 to 10 blocks
- **UI Configuration Screen**: User-friendly interface to control reach settings
- **Enable/Disable Toggle**: Quickly toggle the mod on and off
- **Default Minecraft Reach**: Falls back to default 4.5 block reach when disabled
- **Keybinding Support**: Press `R` (default) to open the configuration screen

## Installation

1. Download the latest release from the [Releases](https://github.com/shinekitsune1-bit/minecraft-reach-mod/releases) page
2. Place the `.jar` file in your Minecraft `mods` folder
3. Ensure you have Fabric Loader and Fabric API installed
4. Launch Minecraft with the Fabric profile

## Usage

1. Press `R` in-game to open the Reach Mod configuration screen
2. Toggle "Reach Mod Enabled" to activate/deactivate the mod
3. Use the `+` and `-` buttons to adjust your reach distance
4. Click "Done" to save your settings

## Configuration

The mod configuration is stored in memory and persists during your gaming session. Settings include:

- **Reach Distance**: Set between 1-10 blocks (default: 4.5)
- **Enabled**: Toggle the mod on/off
- **Min/Max Reach**: Hardcoded limits to prevent abuse

## Compatibility

- **Minecraft Version**: 1.21.8
- **Loader**: Fabric Loader 0.15.11+
- **API**: Fabric API

## Building

```bash
git clone https://github.com/shinekitsune1-bit/minecraft-reach-mod.git
cd minecraft-reach-mod
./gradlew build
```

The compiled JAR will be in `build/libs/`.

## Development

### Project Structure

```
src/main/
├── java/com/shinekitsune/reachmod/
│   ├── ReachMod.java                 # Main mod entry point
│   ├── ReachModClient.java           # Client-side initialization
│   ├── ReachConfig.java              # Configuration management
│   ├── mixin/                        # Mixins for reach modification
│   ├── screen/                       # UI screens
│   └── keybinding/                   # Keybinding handlers
└── resources/
    ├── fabric.mod.json               # Fabric metadata
    └── reach_mod.mixins.json         # Mixin configuration
```

### Key Classes

- **ReachConfig**: Manages reach distance configuration and mod state
- **ReachModScreen**: UI screen for configuration
- **PlayerInteractionManagerMixin**: Server-side reach modification
- **PlayerInteractionClientMixin**: Client-side reach modification
- **KeyBindings**: Keybinding initialization and handling

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

For issues, bugs, or feature requests, please open an issue on the [GitHub Issues](https://github.com/shinekitsune1-bit/minecraft-reach-mod/issues) page.

## Credits

Created by MUSIXSHINE
