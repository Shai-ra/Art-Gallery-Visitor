public class StandardVisitor extends ArtGalleryVisitor{
    
    private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit;
    private float discountPercent;
       
    // Constructor
    public StandardVisitor(int visitorId, String fullName, String gender, String contactNumber,String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
        this.visitLimit = 5;
        this.discountPercent = 0.10f;
        this.isEligibleForDiscountUpgrade = false;
    }
    
    // Accessors
    public boolean getIsEligibleForDiscountUpgrade() {
        return isEligibleForDiscountUpgrade;
    }

    public int getVisitLimit() {
        return visitLimit;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }
    
    // Method to check for discount upgrade
    public boolean checkDiscountUpgrade() {
        if (visitCount >= visitLimit) {
            isEligibleForDiscountUpgrade = true;
            discountPercent = 0.15f;
        }
        return isEligibleForDiscountUpgrade;
    }
    
    //Product purchase buyproduct() from ArtGalleryVisitor
    @Override
    public String buyProduct(String artworkName, double artworkPrice) {
        if (!isActive) {
            return"Visitor is not active. Please log a visit before making a purchase.";
        }else{
            if (!isBought || (this.artworkName == null) || !this.artworkName.equals(artworkName)) {
            this.artworkName = artworkName;
            this.artworkPrice = artworkPrice;
            this.isBought = true;
            this.buyCount++;
            return "Purchase successful: " + artworkName + " for price " + artworkPrice;
            } else {
            return "You have already purchased this artwork.";
            }
        }
        
    }
    
    //Discount calculation
    @Override
    public double calculateDiscount() {
        if (!isBought) {
            return 0;
        } else {
            checkDiscountUpgrade(); // check if eligible for upgrade
             discountAmount = artworkPrice * discountPercent;
             finalPrice = artworkPrice - discountAmount;
            return discountAmount;
        }
    }
    
    
    //Reward points
    @Override
    public double calculateRewardPoint() {
        if (isBought) {
            rewardPoints += finalPrice * 5;
            
        } 
            return rewardPoints; // No change
        
    }
    
    //Bill output
    @Override
    public void generateBill() {
        if (isBought) {
            calculateDiscount(); 
            System.out.println("          === BILL ===");
            System.out.println("|Visitor ID     |" + visitorId);
            System.out.println("|Visitor Name   |" + fullName);
            System.out.println("|Artwork Name   |" + artworkName);
            System.out.println("|Artwork Price  |" + artworkPrice);
            System.out.println("|Discount Amount|" + discountAmount);
            System.out.println("|Final Price    |" + finalPrice);
        } else {
            System.out.println("No purchase has been made to generate a bill.");
        }
    }
    
    //Terminate Visitor
    private void terminateVisitor() {
        isActive = false;
        isEligibleForDiscountUpgrade = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }
    
    // cancelProduct implementation
    @Override
    public String cancelProduct(String artworkName, String cancellationReason) {
        if (cancelCount >= cancelLimit) {
            terminateVisitor();
            return "Cancellation limit reached. Visitor account terminated.";
        }

        if (buyCount == 0) {
            return "No product has been bought to cancel.";
        }

        if ( this.artworkName.equals(artworkName)) {
            //Additional code
            // Store artwork name before clearing it
            String cancelledArtwork = this.artworkName;
            this.artworkName = null;
            isBought = false;
            refundableAmount = artworkPrice - (artworkPrice * 0.10);
            rewardPoints -= finalPrice * 5;
            buyCount--;
            cancelCount++;
            
            this.cancellationReason = cancellationReason;
            return "Product cancelled. Refundable amount: " + refundableAmount;
        } else {
            return "Incorrect artwork name. Cancellation failed.";
        }
    }
    
    // Display method
    @Override
    public void display(){
        super.display();
        System.out.println("Is Eligible For Discount Upgrade: " + isEligibleForDiscountUpgrade);
        System.out.println("Visit Limit for Discount Upgrade: " + visitLimit);
        System.out.println("Current Discount Percent: " + discountPercent);
    }

    
}
