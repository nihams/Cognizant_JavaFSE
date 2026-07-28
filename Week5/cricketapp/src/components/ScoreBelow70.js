function ScoreBelow70({ players }) {
  const players70 = players.filter((player) => player.score <= 70);
  return (
    <div>
      <ul>
        {players70.map((player, index) => (
          <li key={index}>
            Mr {player.name}
            <span> {player.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
}
export default ScoreBelow70;
