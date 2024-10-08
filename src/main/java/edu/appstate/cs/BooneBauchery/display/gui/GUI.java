package edu.appstate.cs.BooneBauchery.display.gui;

/**
 * Hello world!
 *
 */
public class GUI {
  public static int sum(int x, int y) {
    return x + y;
  }

  public static float computePercent(int numerator, int denominator) {
    if (denominator == 0) {
      return 0.0f;
    } else {
      return (numerator * 100.0f) / denominator;
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  public String getBigLogo() {
    return bigLogo;
  }

  public String getString() {
    return testCheck;
  }

  private String bigLogo = " ▄▄▄▄    ▒█████   ▒█████   ███▄    █ ▓█████  ▄▄▄▄    ▄▄▄       █    ██  ▄████▄   ██░ ██ ▓█████  ██▀███ ▓██   ██▓\n"
      + " ▓█████▄ ▒██▒  ██▒▒██▒  ██▒ ██ ▀█   █ ▓█   ▀ ▓█████▄ ▒████▄     ██  ▓██▒▒██▀ ▀█  ▓██░ ██▒▓█   ▀ ▓██ ▒ ██▒▒██  ██▒\n"
      + "▒██▒ ▄██▒██░  ██▒▒██░  ██▒▓██  ▀█ ██▒▒███   ▒██▒ ▄██▒██  ▀█▄  ▓██  ▒██░▒▓█    ▄ ▒██▀▀██░▒███   ▓██ ░▄█ ▒ ▒██ ██░\n"
      + "▒██░█▀  ▒██   ██░▒██   ██░▓██▒  ▐▌██▒▒▓█  ▄ ▒██░█▀  ░██▄▄▄▄██ ▓▓█  ░██░▒▓▓▄ ▄██▒░▓█ ░██ ▒▓█  ▄ ▒██▀▀█▄   ░ ▐██▓░\n"
      + "░▓█  ▀█▓░ ████▓▒░░ ████▓▒░▒██░   ▓██░░▒████▒░▓█  ▀█▓ ▓█   ▓██▒▒▒█████▓ ▒ ▓███▀ ░░▓█▒░██▓░▒████▒░██▓ ▒██▒ ░ ██▒▓░\n"
      + "░▒▓███▀▒░ ▒░▒░▒░ ░ ▒░▒░▒░ ░ ▒░   ▒ ▒ ░░ ▒░ ░░▒▓███▀▒ ▒▒   ▓▒█░░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░ ▒ ░░▒░▒░░ ▒░ ░░ ▒▓ ░▒▓░  ██▒▒▒ \n"
      + "▒░▒   ░   ░ ▒ ▒░   ░ ▒ ▒░ ░ ░░   ░ ▒░ ░ ░  ░▒░▒   ░   ▒   ▒▒ ░░░▒░ ░ ░   ░  ▒    ▒ ░▒░ ░ ░ ░  ░  ░▒ ░ ▒░▓██ ░▒░ \n"
      + "░    ░ ░ ░ ░ ▒  ░ ░ ░ ▒     ░   ░ ░    ░    ░    ░   ░   ▒    ░░░ ░ ░ ░         ░  ░░ ░   ░     ░░   ░ ▒ ▒ ░░  \n"
      + "░          ░ ░      ░ ░           ░    ░  ░ ░            ░  ░   ░     ░ ░       ░  ░  ░   ░  ░   ░     ░ ░     \n"
      + "   ░                                           ░                    ░                                ░ ░     \n";

  private String healthbox = " __| |____________________________________________| |__\n"
      + "(__   ____________________________________________   __)\n"
      + " | |                                            | |\n"
      + "| |                                            | |\n"
      + "| |                                            | |\n"
      + "| |                                            | |\n"
      + "__| |____________________________________________| |__\n"
      + " (__   ____________________________________________   __)\n"
      + "  | |                                            | |\n";
  private String testCheck = "Is anybody there?";
}
