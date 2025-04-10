import CreateTransactionForm from "@/components/CreateTransactionForm";
import UserTransactionsClient from "@/components/UserTransactionsClient";
import { Container, Heading, Box } from "@chakra-ui/react";

export default function UserTransactionsPage({
  params,
}: {
  params: { userId: string };
}) {
  const { userId } = params;
  return (
    <Container maxW="container.lg" py="8">
      <Heading as="h1" mb="6">
        User Transactions
      </Heading>
      {/* Create Transaction Form */}
      <Box mb="8">
        <CreateTransactionForm userId={userId} />
      </Box>
      {/* List Transactions */}
      <UserTransactionsClient userId={userId} />
    </Container>
  );
}
