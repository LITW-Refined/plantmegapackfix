# PlantMegaPackFix

This is a minor mod that attempts to fix critical or server crashing bugs within plant mega pack. This mod requies PlantMegaPack to work.

## Requirements

This mod requires [Plant Mega Pack v4.33](http://web.archive.org/web/20180428140846if_/http://10paksmods.net:80/downloads/plantmegapack-4.33-1.7.10-1492.jar).

## Contribution

Currently there is only one bug fixed as I haven't found more yet. Feel free to open an issue or even make an own fix an create a PR for it.

## Fixes

### Vines cause server loop with following crash

I had to check that via an analytics tool and it took me a long while until I got the reason. The method `genVine()` in `PMPGenVine` in Plant Mega Pack never checks the actual `y` value like all the other `gen...()` methods in other gen classes. The method starts at 255 (max height) and goes down block for block and checks if a vine would be cool to spawn here. If not the values will reach 0 after some time. At this point the method should break and accept that it will not be able to spawn a vine at this x/z position and return. But in PMP it never does. This Mixin fixes it and because I'm bad in replacing single conditions I replaced the whole method via injection.
