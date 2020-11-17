import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();

        Command changeChannel;
        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        turnOnTV.execute();

        for (int i = 0; i < 3; i++) {
            Command command = new ChangeChannelCommand(new Channel(channelList[i]));
            command.execute();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        turnOffTV.execute();
    }
}

class TV {

    void turnOn() {
        System.out.println("Turning on the TV");
    }

    void turnOff() {
        System.out.println("Turning off the TV");
    }
}

class Channel {
    private int channelNumber;

    Channel(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        System.out.println("Channel was changed to " + channelNumber);
    }

}

interface Command {
    void execute();
}

class TurnOnCommand implements Command {
    TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
       tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }

}

class Controller {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void executeCommand() {
        command.execute();
    }
}