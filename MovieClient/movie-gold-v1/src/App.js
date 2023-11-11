
import logo from './logo.svg';
import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from 'react';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';

function App() {

  const [movies, setMovies] = useState();


  const getMovies = async () => {

    try{
    //Using async function to ensure better user experience
      //Passing additional path information
            const response = await api.get("/api/v1/movies");
            console.log(response.data);
            setMovies(response.data);
      } catch(err){
        console.log(err);
      }
  }
  useEffect(() => {
      getMovies();
    },[])

  return (
    <div className="App">
        <Routes>
            <Route path="/" element={<Layout/>}>
                <Route path ="/" element ={<Home/>} ></Route>

            </Route>
        </Routes>
    </div>
  );
}

export default App;



/*
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
*/