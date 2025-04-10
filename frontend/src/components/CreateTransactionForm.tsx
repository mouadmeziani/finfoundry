"use client";
import { useState } from "react";
import {
  Box,
  Button,
  Input,
  Textarea,
  Select,
} from "@chakra-ui/react";
import { toaster } from "@/components/ui/toaster";
import { FormControl, FormLabel } from "@chakra-ui/form-control";
interface CreateTransactionFormProps {
  userId: string;
}

export default function CreateTransactionForm({
  userId,
}: CreateTransactionFormProps) {
  const initialFormState = {
    amount: "",
    description: "",
    date: "",
    type: "",
  };
  const [formData, setFormData] = useState(initialFormState);
  const [errors, setErrors] = useState<Record<string, string>>({});

  const handleInputChange = (
    e: React.ChangeEvent<
      HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement
    >
  ) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setErrors({});

    // Create payload (add userId to the data)
    const payload = { ...formData, userId };

    try {
      const res = await fetch("http://localhost:8080/api/transactions", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      const data = await res.json();
      if (!res.ok) {
        setErrors(data);
        toaster.create({
          title: "Error",
          description: "Failed to create transaction.",
          duration: 5000,
        });
      } else {
        toaster.create({
          title: "Transaction Created",
          description: "The transaction was created successfully.",
          duration: 5000,
        });
        setFormData(initialFormState);
      }
    } catch (err: any) {
      toaster.create({
        title: "Unexpected error",
        description: err.message || "Something went wrong",
        duration: 5000,
      });
    }
  };

  return (
    <Box
      maxW="lg"
      mx="auto"
      mt="8"
      p="6"
      borderWidth="1px"
      borderRadius="md"
      boxShadow="sm"
    >
      <form onSubmit={handleSubmit}>
        <FormControl mb="4" isRequired isInvalid={!!errors.amount}>
          <FormLabel>Amount</FormLabel>
          <Input
            type="number"
            name="amount"
            value={formData.amount}
            onChange={handleInputChange}
          />
          {errors.amount && (
            <Box color="red.500" fontSize="sm">
              {errors.amount}
            </Box>
          )}
        </FormControl>

        <FormControl mb="4" isRequired isInvalid={!!errors.description}>
          <FormLabel>Description</FormLabel>
          <Textarea
            name="description"
            value={formData.description}
            onChange={handleInputChange}
          />
          {errors.description && (
            <Box color="red.500" fontSize="sm">
              {errors.description}
            </Box>
          )}
        </FormControl>

        <FormControl mb="4" isRequired isInvalid={!!errors.date}>
          <FormLabel>Date</FormLabel>
          <Input
            type="date"
            name="date"
            value={formData.date}
            onChange={handleInputChange}
          />
          {errors.date && (
            <Box color="red.500" fontSize="sm">
              {errors.date}
            </Box>
          )}
        </FormControl>

        <FormControl mb="4" isRequired isInvalid={!!errors.type}>
          <FormLabel>Type</FormLabel>
          <select
            name="type"
            value={formData.type}
            onChange={handleInputChange}
          >
            <option value="income">Income</option>
            <option value="expense">Expense</option>
          </select>
          {errors.type && (
            <Box color="red.500" fontSize="sm">
              {errors.type}
            </Box>
          )}
        </FormControl>

        <Button type="submit" colorScheme="blue" width="full">
          Create Transaction
        </Button>
      </form>
    </Box>
  );
}
