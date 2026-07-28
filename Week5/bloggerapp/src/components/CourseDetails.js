const course = {
  c1: {
    name: "Angular",
    date: "4/5/2021",
  },
  c2: {
    name: "React",
    date: "6/3/2020",
  },
};
function CourseDetails() {
  return (
    <>
      <h1>Course Details</h1>

      <h2>{course.c1.name}</h2>
      <h4>{course.c1.date}</h4>

      <h2>{course.c2.name}</h2>
      <h4>{course.c2.date}</h4>
    </>
  );
}

export default CourseDetails;
