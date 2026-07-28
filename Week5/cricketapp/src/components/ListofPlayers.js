import React from "react";
export const players = [
  { name: "Virat", score: 90 },
  { name: "Rohit", score: 82 },
  { name: "Gill", score: 68 },
  { name: "Rahul", score: 45 },
  { name: "Hardik", score: 75 },
  { name: "Jadeja", score: 60 },
  { name: "Ashwin", score: 55 },
  { name: "Bumrah", score: 72 },
  { name: "Shami", score: 30 },
  { name: "Siraj", score: 65 },
  { name: "Kuldeep", score: 80 },
];

function ListOfPlayers({ players }) {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>
          Mr.{item.name}
          <span> {item.score}</span>
        </li>
      ))}
    </ul>
  );
}
export default ListOfPlayers;
