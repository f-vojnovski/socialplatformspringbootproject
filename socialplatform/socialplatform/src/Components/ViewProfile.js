import React, { Component } from "react";
import {
    BrowserRouter as Router,
    Link,
    useLocation
} from "react-router-dom";
import axios from "axios";

export default class ViewProfile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        }
    }

    componentDidMount() {
        axios.post("http://localhost:8080/getPostsByUser", {
           searchInput: "vancho"
        },
        {withCredentials: true})
            .then(res => {
                const posts = res.data.map(obj => ({id: obj.id, content: obj.content, user: obj.user}));
                this.setState({ posts });
                console.log(this.state.posts);
            })
    }


    render() {
        return (
            <div>
                <h1>{this.props.user.username}</h1>
                <p>{this.props.user.name} {this.props.user.surname}</p>
                <ul>
                    {this.state.posts.map(post => (
                        <li key = {post.id}>
                            {post.user.username}<br/>
                            {post.content}
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}