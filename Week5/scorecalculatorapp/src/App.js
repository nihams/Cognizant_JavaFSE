import "./App.css";
import { CalculateScore } from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name={"Steve"}
        School={"DNV School"}
        total={284}
        goal={300}
      />
    </div>
  );
}

export default App;
