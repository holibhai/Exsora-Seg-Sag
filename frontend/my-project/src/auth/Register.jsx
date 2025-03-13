import React, { useState } from "react";
import axios from "axios";

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    username: "",
    password: "",
    role: "USER",
    address: {
      street: "",
      city: "",
      state: "",
      zip: "",
    },
  });

  // Handle input change
  const handleChange = (e) => {
    console.log(formData)
    const { name, value } = e.target;

    // Handle nested address object separately
    if (name.startsWith("address.")) {
      const field = name.split(".")[1];
      setFormData((prevData) => ({
        ...prevData,
        address: { ...prevData.address, [field]: value },
      }));
    } else {
      setFormData((prevData) => ({
        ...prevData,
        [name]: value,
      }));
    }
  };

  // Submit handler using Axios
  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("Submit");



    try {
      console.log("Submit");
      const response = await axios.post("http://localhost:8080/api/authentication/register", formData,{
        headers: {
          'Content-Type': 'application/json',
        },
      }
        
      );
       console.log(response)
      if (response.status === 200) {
        alert("Registration successful!");
      } else {
        alert("Error during registration.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert(error.response?.data?.message || "Registration failed.");
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded-lg shadow-lg w-96"
      >
        <h2 className="text-2xl font-semibold mb-4">Register</h2>

        {/* First Name */}
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={formData.firstName}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />

        {/* Last Name */}
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={formData.lastName}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />

        {/* Username (Email) */}
        <input
          type="email"
          name="username"
          placeholder="Email"
          value={formData.username}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />

        {/* Password */}
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />

        {/* Address Fields */}
        <h3 className="font-semibold mt-2">Address</h3>
        <input
          type="text"
          name="address.street"
          placeholder="Street"
          value={formData.address.street}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />
        <input
          type="text"
          name="address.city"
          placeholder="City"
          value={formData.address.city}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />
        <input
          type="text"
          name="address.state"
          placeholder="State"
          value={formData.address.state}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />
        <input
          type="text"
          name="address.zip"
          placeholder="ZIP Code"
          value={formData.address.zip}
          onChange={handleChange}
          className="w-full p-2 mb-2 border rounded"
          required
        />

        {/* Submit Button */}
        <button
          type="submit"
          className="w-full bg-blue-500 text-white p-2 rounded mt-4 hover:bg-blue-600"
        >
          Register
        </button>
      </form>
    </div>
  );
};

export default Register;
