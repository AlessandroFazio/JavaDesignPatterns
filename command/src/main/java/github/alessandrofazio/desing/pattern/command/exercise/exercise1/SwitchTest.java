package github.alessandrofazio.desing.pattern.command.exercise.exercise1;

import github.alessandrofazio.desing.pattern.command.exercise.exercise1.invoker.Switch;
import github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver.Fan;
import github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver.Light;

public class SwitchTest {
    public static void main(String[] args) {
        Light light = new Light();
        Switch<Light> lightSwitch = Switch.factory(
                light::turnOn, light::turnOff);
        lightSwitch.flipDown();
        lightSwitch.flipUp();

        Fan fan = new Fan();
        Switch<Fan> fanSwitch = Switch.factory(
                fan::startRotate, fan::stopRotate);
        fanSwitch.flipUp();
        fanSwitch.flipDown();
    }
}
