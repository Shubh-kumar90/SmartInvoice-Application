import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import Invoices from "./pages/Invoices";

function App() {

  return (

    <BrowserRouter>

      <nav className="navbar navbar-dark bg-dark navbar-expand-lg">

        <div className="container">

          <Link className="navbar-brand" to="/">
            Smart Invoice
          </Link>

          <div className="navbar-nav">

            <Link className="nav-link" to="/dashboard">
              Dashboard
            </Link>

            <Link className="nav-link" to="/invoices">
              Invoices
            </Link>
        </div>
        </div>
      </nav>

      <Routes>

        <Route path="/" element={<Login />} />

        <Route path="/dashboard" element={<Dashboard />} />

        <Route path="/invoices" element={<Invoices />} />

      </Routes>

    </BrowserRouter>
  );
}

export default App;
