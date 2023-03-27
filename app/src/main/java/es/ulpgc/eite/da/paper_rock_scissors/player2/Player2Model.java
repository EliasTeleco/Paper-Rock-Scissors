package es.ulpgc.eite.da.paper_rock_scissors.player2;

/**
 * Created by Luis on marzo, 2023
 */

public class Player2Model implements Player2Contract.Model {

  public static String TAG = "Paper-Rock-Scissors.Player2Model";

  private String playerOption;

  public Player2Model() {
    this.playerOption = "?";
  }

  @Override
  public String getStoredData() {
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

  @Override
  public void setOption(String option) {

  }
}
