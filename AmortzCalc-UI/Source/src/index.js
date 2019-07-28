import React from 'react';
import ReactDOM from 'react-dom';
import HomeLayout from './client/components/Layout/HomeLayout.js';
import Notfound from './notfound.js';
import { Route, Link, BrowserRouter as Router, Switch, Redirect, BrowserHistory } from 'react-router-dom';


const routing = (
  <Router>
  <div>
    <Route exact path="/" component={HomeLayout} />
  </div>
  </Router>
)
ReactDOM.render(routing, document.getElementById('root'));
