import "../Stylesheets/mystyles.css";

const calcScore = (total, goal) => {
  return (total / goal).toFixed(2) + "%";
};
export const CalculateScore = ({ Name, School, total, goal }) => {
  return (
    <div className="formatstyle">
      <h1 style={{ color: "brown" }}>Student Details</h1>

      <div className="Name">
        <b>
          <span>Name: </span>
        </b>
        <span>{Name}</span>
      </div>

      <div className="School">
        <b>
          <span>School: </span>
        </b>
        <span>{School}</span>
      </div>

      <div className="Total">
        <b>
          <span>Total: </span>
        </b>
        <span>{total}</span>
        <span> Marks</span>
      </div>

      <div className="Score">
        <b>Score: </b>
        <span>{calcScore(total, goal)}</span>
      </div>
    </div>
  );
};
