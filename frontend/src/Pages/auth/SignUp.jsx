import React from "react";
import "../../styles/SignUp.css";
import { Link, useLocation, useNavigate } from "react-router-dom";


export default function SignUp() {
    const navigate = useNavigate();
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Form Submitted");
        console.log("Role:", role);
        try {
            // Call backend API here

            alert("Account created successfully!");

            navigate("/login");
        } catch (error) {
            alert("Registration failed");
        }

    };

    const location = useLocation();
    const role = location.state.role;


    return (

        <div className="signup-container">
            <div className="signup-card">

                <h1>Create Account as {role}</h1>
                <p>Join AgriRental today</p>

                <form className="signup-form" onSubmit={handleSubmit}>

                    <input type="text" placeholder="Full Name" required />
                    <input type="tel" placeholder="Phone Number" required />

                    <input type="email" placeholder="Email Address" required />
                    <input type="text" placeholder="Username" required />

                    <input type="text" placeholder="State" required />
                    <input type="text" placeholder="District" required />

                    <input type="text" placeholder="Village" required />
                    <input type="text" placeholder="Pincode" required />

                    <input type="password" placeholder="Password" required />
                    <input type="password" placeholder="Confirm Password" required />

                    <button type="submit">
                        Create Account
                    </button>

                </form>

                <p className="login-link">
                    Already have an account?
                    <Link to="/login"> Login</Link>
                </p>

            </div>
        </div>

    );

};