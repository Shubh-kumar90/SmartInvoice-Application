import { useEffect, useState } from "react";
import API from "../services/api";

function Invoices() {

  const [invoices, setInvoices] = useState([]);

  useEffect(() => {

    fetchInvoices();

  }, []);

  const fetchInvoices = async () => {

    try {

      const response = await API.get("/invoice/all");

      setInvoices(response.data);

    } catch (error) {

      console.log(error);
    }
  };
    return (
    <div className="container mt-5">

      <h2 className="mb-4">
        All Invoices
      </h2>

      <table className="table table-bordered table-striped">

        <thead>
          <tr>
            <th>ID</th>
            <th>Invoice Number</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Status</th>
          </tr>
        </thead>

                <tbody>
                    
          {invoices.map((invoice) => (

            <tr key={invoice.id}>
              <td>{invoice.id}</td>
              <td>{invoice.invoiceNumber}</td>
              <td>{invoice.vendorName}</td>
              <td>{invoice.amount}</td>
              <td>{invoice.status}</td>
            </tr>
          ))}

        </tbody>

      </table>
    </div>
  );
}

export default Invoices;
