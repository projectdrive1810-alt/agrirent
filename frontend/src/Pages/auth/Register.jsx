import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "../../styles/Register.css";


function Register() {
  const navigate = useNavigate();
  return (
    <>

      <div className="register-container">
        <div className="left-panel">
          <div className="overlay">
            <h1>
              Join <span>Agrirental</span>
            </h1>

            <h2>Connect. Rent. Grow.</h2>

            <p>
              Create your account and become part of the smart farming community.
            </p>

            <div className="features">
              <div> Wide Range of Equipment</div>
              <div> Trusted & Secure</div>
              <div> Grow Better Together</div>
            </div>
          </div>
        </div>

        <div className="right-panel">

          <h1>Register</h1>

          <p>Select how you want to join AgriRental</p>

          <div className="card "
            onClick={() => navigate("/signup", {
              state: { role: "User" }
            })}
          >
            <h3> I am a User</h3>
            <p>Rent equipment for your farming needs.</p>
          </div>

          <div className="card"
            onClick={() => navigate("/signup", {
              state: { role: "Admin" }
            })}
          >
            <h3> I am an Admin</h3>
            <p>List your equipment and earn more.</p>
          </div>

          <p className="login-link">
            Already have an account?
            <Link to="/signup"> Login</Link>
          </p>

        </div>

      </div>
    </>
  );
}


export default Register;