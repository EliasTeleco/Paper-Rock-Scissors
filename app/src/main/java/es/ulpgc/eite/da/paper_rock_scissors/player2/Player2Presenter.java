package es.ulpgc.eite.da.paper_rock_scissors.player2;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.paper_rock_scissors.game.AppMediator;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player1ToPlayer2State;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player2ToPlayer1State;


/**
 * Created by Luis on marzo, 2023
 */

public class Player2Presenter implements Player2Contract.Presenter {

  public static String TAG = "Paper-Rock-Scissors.Player2Presenter";

  private WeakReference<Player2Contract.View> view;
  private Player2State state;
  private Player2Contract.Model model;
  private AppMediator mediator;

  public Player2Presenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = new Player2State();

    // TODO: add code if is necessary
    state.optionClicked = false;
    state.option = "?";


  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: add code if is necessary

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: add code if is necessary
    Player1ToPlayer2State savedState =getStateFromPlayer1();
    if(savedState !=null){
      model.onUpdatedDataFromPreviousScreen(savedState.playerOption);


      view.get().onViewModelDataUpdated(state);

    }
    model.onUpdatedDataFromPreviousScreen(savedState.playerOption);


    view.get().onViewModelDataUpdated(state);
    // update the view
    view.get().onViewModelDataUpdated(state);

  }

   private Player1ToPlayer2State getStateFromPlayer1() {
      Player1ToPlayer2State state = mediator.getPlayer1ToPlayer2ScreenState();
      return state;
  }


  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: add code if is necessary

  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: add code if is necessary

  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: add code if is necessary

  }

  @Override
  public void onButtonClicked(String option) {
    Log.e(TAG, "onButtonClicked()");

    // TODO: add code if is necessary

    state.optionClicked =  true;
    state.playerOption = model.getStoredData();

    view.get().onViewModelDataUpdated(state);


    //Pasar estado a otra pantalla
    Player2ToPlayer1State newState = new Player2ToPlayer1State();
    newState.playerOption = model.getStoredData();
    passToPlayer1Screen (newState);
    view.get().navigateToNextScreen();

  }

  private void passToPlayer1Screen(Player2ToPlayer1State state) {
    mediator.setPlayer2ToPlayer1ScreenState(state);
  }


  @Override
  public void injectView(WeakReference<Player2Contract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(Player2Contract.Model model) {
    this.model = model;
  }

}