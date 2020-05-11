import React, { Component } from "react";
import axios from 'axios';

export default class Registration extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            name: "",
            surname: "",
            password: "",
            confirmPassword: "",
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
        console.log("Registration form submitted");
        console.log(this.state.username);
        axios.post("http://localhost:8080/registerNewUser/", {
                username: this.state.username,
                name: this.state.name,
                surname: this.state.surname,
                password: this.state.password,
                passwordConfirm: this.state.confirmPassword
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
                       name="name"
                       placeholder="Name"
                       value={this.state.name}
                       onChange={this.handleChange}
                       required />
                </div>
                <div className="form-group">
                <input className="form-control"
                       name="surname"
                       placeholder="Surname"
                       value={this.state.surname}
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
                <div className="form-group">
                <input className="form-control"
                       type="password"
                       name="confirmPassword"
                       placeholder="Confirm password"
                       value={this.state.confirmPassword}
                       onChange={this.handleChange}
                       required />
                </div>
                <button className="btn btn-primary" type="submit">Register</button>
            </form>
        </div>)
    }
}