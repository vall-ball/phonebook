import java.security.Key;

class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        /* Your subsystems */
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();
        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    Processor processor;
    Monitor monitor;
    Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.processor = processor;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        keyboard.off();

        monitor.off();
        processor.off();

    }
}

class Processor {
    /* Your subsystem description */

    public void on() {
        System.out.println("Processor on");
    }

    public void off() {
        System.out.println("Processor off");
    }
}

class Monitor {
    /* Your subsystem description */

    public void on() {
        System.out.println("Monitor on");
    }

    public void off() {
        System.out.println("Monitor off");
    }
}

class Keyboard {
    /* Your subsystem description */

    public void on() {
        System.out.println("Keyboard on");
        turnOnBacklight();
    }

    public void off() {
        System.out.println("Keyboard off");
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        System.out.println("Backlight is turned off");
    }
}