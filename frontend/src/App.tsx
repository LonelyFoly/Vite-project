import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./components/screens/home/Home.tsx";
import Auth from "./components/screens/auth/Auth.tsx";
import Tasks from "./components/screens/tasks/Tasks.tsx";
import Projects from "./components/screens/projects/Projects.tsx";

function App() {

  return (
      <BrowserRouter>

        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/auth" element={<Auth />}/>
          <Route path="/registration" element={<Auth />}/>
          <Route path="/tasks" element={<Tasks/>}/>
          <Route path="/projects" element={<Projects/>}/>
        </Routes>
      </BrowserRouter>
  )
}

export default App
