import React, { Component } from "react";
import axios from 'axios';

export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: "",
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit(event) {
        console.log("Login form submitted");
        console.log(this.state.username);
        axios.post("http://localhost:8080/perform_login", {
                username: this.state.username,
                password: this.state.password,
            },
            {withCredentials: true},
        )
        event.preventDefault();
    }
    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <input className="form-control"
                           name="username"
                           placeholder="Username"
                           value={this.state.username}
                           onChange={this.handleChange}
                           required />
                </div>
                <div className="form-group">
                    <input className="form-control"
                           type="password"
                           name="password"
                           placeholder="Password"
                           value={this.state.password}
                           onChange={this.handleChange}
                           required />
                </div>
                <button className="btn btn-primary" type="submit">Login</button>
            </form>
        </div>)
    }
}