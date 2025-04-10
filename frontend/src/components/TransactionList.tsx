import { Box, Text } from "@chakra-ui/react";
import { Transaction } from "@/types/transaction";
import TransactionCard from "./TransactionCard";

type TransactionListProps = {
  transactions: Transaction[];
};

export default function TransactionList({ transactions }: TransactionListProps) {
  if (!transactions || transactions.length === 0) {
    return <Text>No transactions available.</Text>;
  }
  return (
    <Box>
      {transactions.map((tx) => (
        <TransactionCard key={tx.id} transaction={tx} />
      ))}
    </Box>
  );
}
