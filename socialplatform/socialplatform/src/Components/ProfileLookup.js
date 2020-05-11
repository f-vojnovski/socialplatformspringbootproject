import React, { Component } from "react";
import axios from 'axios';
import ViewProfile from "./ViewProfile";
import AddFriendButton from "./AddFriendButton";

export default class ProfileLookup extends Component {
    constructor(props) {
        super(props);

        this.state = {
            searchInput: "",
            results: [],
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
        axios.post("http://localhost:8080/searchForUser/", {
                searchInput: this.state.searchInput,
            },
            {withCredentials: true},
        ). then(res => {
            this.setState({ results: res.data });
            console.log(this.state);
            }
        ). catch(error =>
            console.log(error.response)
        )
        event.preventDefault();
    }
    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <input className="form-control"
                           name="searchInput"
                           placeholder="Look for a person"
                           value={this.state.searchInput}
                           onChange={this.handleChange}
                           required />
                </div>
                <button className="btn btn-primary" type="submit">Search</button>
            </form>

            <div>
                {this.state.results.map((user, index) => (
                   // <li key={index} user={user} >{user.username}</li>
                    <div>
                        <ViewProfile user = {user} />
                        <AddFriendButton username = {user.username}/>
                    </div>
                ))}
            </div>
        </div>)
    }
}