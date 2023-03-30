package es.ulpgc.eite.da.paper_rock_scissors.player1;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.paper_rock_scissors.game.AppMediator;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player1ToPlayer2State;
import es.ulpgc.eite.da.paper_rock_scissors.game.Player2ToPlayer1State;


/**
 * Created by Luis on marzo, 2023
 */

public class Player1Presenter implements Player1Contract.Presenter {

  public static String TAG = "Paper-Rock-Scissors.Player1Presenter";

  private WeakReference<Player1Contract.View> view;
  private Player1State state;
  private Player1Contract.Model model;
  private AppMediator mediator;

  public Player1Presenter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = new Player1State();

    // TODO: add code if is necessary
    model.onUpdatedDataFromRestartedScreen("?");
    state.playerOption = model.getStoredData();


    view.get().onViewModelDataUpdated(state);


  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: add code if is necessary
        state = mediator.getPlayer1ScreenState();
        model.onUpdatedDataFromRestartedScreen(state.playerOption);
        view.get().onViewModelDataUpdated(state);



  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: add code if is necessary
    Player2ToPlayer1State savedState = mediator.getPlayer2ToPlayer1ScreenState();
    if(savedState != null){
      model.onUpdatedDataFromRestartedScreen(savedState.playerOption);
        state.playerOption = model.getStoredData();
    }

    // update the view
    view.get().onViewModelDataUpdated(state);

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
     mediator.setPlayer1ScreenState(state);

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

    Player1ToPlayer2State estadoBotonPulsado = new Player1ToPlayer2State();
    if(option.equals("Paper")){
      state.playerOption = "Paper";
      estadoBotonPulsado.playerOption = state.playerOption;
    }else if (option.equals("Rock")){
      state.playerOption = "Rock";
      estadoBotonPulsado.playerOption = state.playerOption;
    }else if (option.equals("Scissors")) {
      state.playerOption = "Scissors";
      estadoBotonPulsado.playerOption = state.playerOption;
    }else{
      state.playerOption = "?";
      estadoBotonPulsado.playerOption = state.playerOption;
    }

    //Pasar estado a otra pantalla
      passToPlayer2Screen (estadoBotonPulsado);
      Log.e(TAG, "estadoBotonPulsado:   "+ estadoBotonPulsado);
      view.get().navigateToNextScreen();


  }

  private void passToPlayer2Screen(Player1ToPlayer2State state) {
      mediator.setPlayer1ToPlayer2ScreenState(state);
  }


  @Override
  public void injectView(WeakReference<Player1Contract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(Player1Contract.Model model) {
    this.model = model;
  }

}