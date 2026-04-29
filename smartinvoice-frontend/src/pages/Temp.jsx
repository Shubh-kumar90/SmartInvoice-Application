import { useEffect, useState } from "react";
import API from "../services/api";

function Dashboard() {

  const [stats, setStats] = useState({});

  useEffect(() => {

    fetchDashboard();

  }, []);

  const fetchDashboard = async () => {

    try {

      const response = await API.get("/dashboard/stats");

      setStats(response.data);

    } catch (error) {

      console.log(error);
    }
  };

  return (
      <div className="container mt-5">
       <h2 className="mb-4">
        Financial Dashboard
      </h2>

      <div className="row g-4">

        <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Total Invoices</h5>
            <h2>{stats.totalInvoices}</h2>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Paid Invoices</h5>
            <h2>{stats.paidInvoices}</h2>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Pending Invoices</h5>
            <h2>{stats.pendingInvoices}</h2>
          </div>
        </div>

 <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Approved Invoices</h5>
            <h2>{stats.approvedInvoices}</h2>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Rejected Invoices</h5>
            <h2>{stats.rejectedInvoices}</h2>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow p-3">
            <h5>Total Amount</h5>
            <h2>₹ {stats.totalInvoiceAmount}</h2>
          </div>
        </div>

      </div>
    </div>
  );
}

export default Dashboard;
