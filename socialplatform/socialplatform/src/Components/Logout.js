import React, { Component } from "react";
import axios from "axios";
import Link from "react";

export default class Logout extends Component {
    componentDidMount() {
        axios.get("http://localhost:8080/logout", {withCredentials: true});
    }

    render() {
        return (
            <div>
                <div>Successfuly logged out</div>
            </div>
    );
    }
}