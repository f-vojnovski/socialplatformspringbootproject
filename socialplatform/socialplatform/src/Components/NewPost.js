import React, { Component } from "react";
import axios from 'axios';

export default class NewPost extends Component {
    constructor(props) {
        super(props);

        this.state = {
            postContent: "",
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
        axios.post("http://localhost:8080/newPost", {
                content: this.state.postContent,
            },
            {withCredentials: true}
        )
        event.preventDefault();
    }
    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <input className="form-control"
                           name="postContent"
                           placeholder="What do you want to post?"
                           value={this.state.postContent}
                           onChange={this.handleChange}
                           required />
                </div>
                <button type="submit" className="btn btn-primary">Post</button>
            </form>
        </div>)
    }
}