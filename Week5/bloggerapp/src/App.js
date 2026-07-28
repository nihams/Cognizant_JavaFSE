import "./App.css";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

const showBooks = true;
const showBlogs = true;
const showCourses = true;

let courseData;
if (showCourses) courseData = <CourseDetails />;
else courseData = <h2>No Course Details</h2>;

function App() {
  return (
    <div className="App">
      <div className="box">{courseData}</div>
      <div className="box">{showBooks && <BookDetails />}</div>
      <div className="box">
        {showBlogs ? <BlogDetails /> : <h2>No Blog Details</h2>}
      </div>
    </div>
  );
}

export default App;
