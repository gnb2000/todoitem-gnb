import './App.css';
import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  Redirect
  
   
} from "react-router-dom";
import Home from './pages/Home';
import Items from './pages/Items';
import Login from './pages/Login';


function App() {
  return (
    
      <Router>
        <Switch>
          <Route path="/home/:id" component={Home}/>
          <Route path="/login" component={Login}/>
          <Route exact path="/items/:id" component={Items}/>
          <Route path="" component={Home}/>
          
          
          
        </Switch>
      </Router>
      
    
  );
}

export default App;
