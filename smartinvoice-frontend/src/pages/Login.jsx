import { useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

const handleLogin = async (e) => {

  e.preventDefault();

  try {

    const response = await API.post(
      "/auth/login",
      {
        email,
        password,
      },
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );

    console.log(response);

    const token = response.data;

    localStorage.setItem("token", token);

    alert("Login Successful");

    navigate("/dashboard");

  } catch (error) {

    console.log(error);

    alert("Invalid Credentials");
  }
};

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-4">

          <div className="card shadow p-4">

            <h2 className="text-center mb-4">
              Smart Invoice Login
            </h2>

            <form onSubmit={handleLogin}>
 <input
                type="email"
                placeholder="Enter Email"
                className="form-control mb-3"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />

              <input
                type="password"
                placeholder="Enter Password"
                className="form-control mb-3"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />

              <button className="btn btn-primary w-100">
                Login
              </button>

            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;