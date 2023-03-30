package es.ulpgc.eite.da.paper_rock_scissors.player1;

/**
 * Created by Luis on marzo, 2023
 */

public class Player1Model implements Player1Contract.Model {

  public static String TAG = "Paper-Rock-Scissors.Player1Model";

  private String playerOption;


  public Player1Model() {
    this.playerOption = "?";
  }

  @Override
  public String getStoredData () {
    // Log.e(TAG, "getStoredData()");

    // TODO: add code if is necessary

    return playerOption;
  }

  @Override
  public String getUpdatedDataDuringPause() {
    // Log.e(TAG, "getUpdatedDataDuringPause()");

    // TODO: add code if is necessary

    return playerOption;
  }

  @Override
  public void onUpdatedDataFromRestartedScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromRestartedScreen()");

    // TODO: add code if is necessary
    playerOption = data;
  }

  @Override
  public void onUpdatedDataFromNextScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromNextScreen()");

    // TODO: add code if is necessary

  }

  @Override
  public void onUpdatedDataFromPreviousScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromPreviousScreen()");

    // TODO: add code if is necessary

  }
}
