package i0.sealights.synth;

public class Application {

  public static void main(String[] args) {

    int i = 0;
    while (i < Integer.MAX_VALUE) {

      if (i % 20 == 0) {
        System.out.println("App is running: " + i);
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      i++;
    }
  }
}
