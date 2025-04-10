"use client";
import { useEffect, useState } from "react";
import { Box, Spinner, Text } from "@chakra-ui/react";
import { Transaction } from "@/types/transaction";
import TransactionList from "@/components/TransactionList";

type Props = {
  userId: string;
};

export default function UserTransactionsClient({ userId }: Props) {
  const [transactions, setTransactions] = useState<Transaction[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchTransactions = async () => {
      try {
        setLoading(true);
        const res = await fetch(
          `http://localhost:8080/api/transactions/user/${userId}`
        );
        if (!res.ok) {
          throw new Error("Failed to fetch transactions");
        }
        const data = await res.json();
        setTransactions(data);
      } catch (err: any) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchTransactions();
  }, [userId]);

  if (loading)
    return (
      <Box textAlign="center" py="10">
        <Spinner size="xl" />
        <Text mt="4">Loading transactions...</Text>
      </Box>
    );

  if (error)
    return (
      <Box textAlign="center" py="10">
        <Text color="red.500">{error}</Text>
      </Box>
    );

  return <TransactionList transactions={transactions} />;
}


