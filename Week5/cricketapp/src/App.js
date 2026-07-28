import React from "react";
import "./App.css";

import ListofPlayers, { players } from "./components/ListofPlayers";
import ScoreBelow70 from "./components/ScoreBelow70";

import {
  OddPlayers,
  EvenPlayers,
  IndianPlayers,
  ListofIndianPlayers,
  IndianTeam,
} from "./components/IndianPlayers";

function App() {
  var flag = true;
  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />

        <h1>List of Players having Scores Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>
        <h2>Odd Players</h2>
        <OddPlayers team={IndianTeam} />
        <hr />

        <h2>Even Players</h2>
        <EvenPlayers team={IndianTeam} />
        <hr />

        <h1>List of Indian Players Merged</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;
