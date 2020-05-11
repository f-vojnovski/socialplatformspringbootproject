import React from 'react';
import Registration from './Components/Registration';
import Login from './Components/Login';
import './App.css';
import ShowPosts from './Components/ShowPosts';
import NewPost from "./Components/NewPost";
import MyProfile from "./Components/MyProfile";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import Logout from "./Components/Logout";
import axios from "axios";
import ProfileLookup from "./Components/ProfileLookup";
import ViewProfile from "./Components/ViewProfile";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loggedIn: false,
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/username", {withCredentials: true})
            .then((res =>  {
                if (res.data !== '')
                this.setState({
                    loggedIn: true
                });
            }))
    }

    render() {
        const loggedIn = this.state.loggedIn;

        if (!loggedIn) return [
            <div>
                <ProfileLookup/>
                <RenderNotLoggedIn/>
            </div>
        ];
        else return [
            <div>
                <ProfileLookup/>
                <RenderLoggedIn/>
            </div>
        ];
    }
}

function RenderNotLoggedIn() {
    return (
        <Router>
            <div>
                <nav>
                    <ul className="navbar">
                        <li className="nav-item">
                            <Link to="/">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/register">Register</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/login">Login</Link>
                        </li>
                    </ul>
                </nav>
                <Switch>
                    <Route path="/register">
                        <Registration />
                    </Route>
                    <Route path="/login">
                        <Login />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

function RenderLoggedIn() {
    return (
        <Router>
            <div>
                <nav>
                    <ul className="navbar">
                        <li className="nav-item">
                            <Link to="/showPosts">Feed</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/newPost">New Post</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/myProfile">My Profile</Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/logout">Log out</Link>
                        </li>
                    </ul>
                </nav>
                <Switch>
                    <Route path="/showPosts">
                        <ShowPosts />
                    </Route>
                    <Route path="/newPost">
                        <NewPost />
                    </Route>
                    <Route path="/myProfile">
                        <MyProfile />
                    </Route>
                    <Route path="/logout">
                        <Logout />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

export default App;
