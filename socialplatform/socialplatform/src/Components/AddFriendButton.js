import React, {Component} from "react";
import axios from "axios";

export default class AddFriendButton extends Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        axios.post("http://localhost:8080/addFriend", {
                searchInput: this.props.username,
            },
            {withCredentials: true},
        )
        console.log(this.props.username)
    }

    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>
                <button className="btn btn-primary" type="submit">Add Friend</button>
            </form>
        </div>)
    }
}