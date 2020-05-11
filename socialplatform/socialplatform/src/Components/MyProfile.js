import React, { Component } from "react";
import axios from "axios";

export default class MyProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/getMyPosts", {withCredentials: true})
            .then(res => {
                const posts = res.data.map(obj => ({id: obj.id, content: obj.content, user: obj.user}));
                this.setState({ posts });
                console.log(this.state.posts);
            })
    }


    render() {
        return (
            <div>
                <div>My Posts</div>
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