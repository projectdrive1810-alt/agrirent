import React from "react";
import { Link } from "react-router-dom";
import "../../styles/Login.css";

export default function Login() {

  const handleSubmit = (e) => {
    e.preventDefault();

    // Backend API Call
    console.log("Login Successful");
  };

  return (
    <div className="login-container">

      <div className="login-card">

        <h1>Welcome Back</h1>
        <p>Login to your AgriRental account</p>

        <form onSubmit={handleSubmit}>

          <input
            type="email"
            placeholder="Email Address"
            required
          />

          <input
            type="password"
            placeholder="Password"
            required
          />

          <div className="options">
            

            <Link to="/forgot-password">
              Forgot Password?
            </Link>
          </div>

          <button type="submit" onSubmit={handleSubmit}>
            Login
          </button>

        </form>

        <p className="register-link">
          Don't have an account?
          <Link to="/"> Register</Link>
        </p>

      </div>

    </div>
  );
}